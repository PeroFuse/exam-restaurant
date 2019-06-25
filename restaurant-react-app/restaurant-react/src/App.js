import React from 'react';
import logo from './logo.svg';
import './App.css';



function App() {

 function onClick(e){
   e.preventDefault();
        fetch('http://localhost:8080/updateUser', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        firstParam: 'yourValue',
        secondParam: 'yourOtherValue',
      })
    })
  }
  return (
    <div className="App">
      <form>
        <input type="text" placeholder="Vardas"></input>
        <input type="text" placeholder="Pavarde"></input>
      </form>
      <button onClick={(e)=> onClick(e)} variant="danger">Sukurti </button>
    </div>
  );
}

export default App;
