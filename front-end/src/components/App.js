import React, { Component } from 'react';
import PageTemplate from './PageTemplate';
import TodoInput from './TodoInput';
import TodoList from './TodoList';
import axios from 'axios';

class App extends Component {

    state = {
        input : '',
        todos: []
    }

    componentDidMount(){
        let getBoard = () => {
            axios.get("http://localhost:8080/v1/board/").then(response => {
            this.setState({
                todos : response.data
            })
        });
        }
        getBoard();
    }

    getId = () =>{
        return this.state.todos[this.state.todos.length-1].id+1;
    }

    handleChange = (e) => {
        const { value } = e.target;
        this.setState({
            input : value
        })
    }

    handleInsert = () => {
        const {todos, input} = this.state;
        const newTodo = {
            title: input,
            done: false,
            id: this.getId()
        };
        axios.post('http://localhost:8080/v1/board/'
            , {title:input, writer:"admin"});

        this.setState({
            todos:[...todos, newTodo],
            input: ''
        });
    }

    handleToggle = (id) => {
        const { todos } = this.state;

        // id로 배열의 index를 찾는다.
        const index = todos.findIndex(todo => todo.id === id);
        const done = todos[index].done;
 
        axios.put('http://localhost:8080/v1/board/'+id
            , {done:!done});

        // 찾은 데이터의 done 값을 반전시킨다.
        const toggled = {
            ...todos[index],
            done: !todos[index].done
        }

        // slice를 사용하여 위에서 찾은 index 전후의 데이터들을 복사.
        // 그 사이에는 변경된 todos 객체를 넣어준다.
        this.setState({
            todos : [
                ...todos.slice(0, index),
                toggled,
                ...todos.slice(index + 1, todos.length)
            ]
        });
    }

    handleRemove = (id) =>{

        axios.delete("http://localhost:8080/v1/board/"+id).then(response => {});

        const { todos } = this.state;
        const index = todos.findIndex(todo => todo.id === id);

        this.setState({
            todos: [
                ...todos.slice(0, index),
                ...todos.slice(index+1, todos.length)
            ]
        })
    }

    render(){
        const { input, todos } = this.state;
        const { handleChange, handleInsert, handleToggle, handleRemove } = this;
        
        return(
            <PageTemplate>
                <TodoInput onChange={handleChange} onInsert={handleInsert} value={input}/>
                <TodoList todos={todos} onToggle={handleToggle} onRemove={handleRemove}/>
            </PageTemplate>
        );
    }
}

export default App;