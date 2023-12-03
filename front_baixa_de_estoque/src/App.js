import logo from './logo.svg';
import './App.css';
import React, {useState} from 'react'

function App() {

  return (
    <div className="App">
      <header className="App-header"
      > <h2>Acerto</h2>
        <form onSubmit={{}} className='containerFlex'>
          <div className='Formulario'>

            <label>
              <div>Produto</div>
              <input></input>
            </label>

            <label className='labelFlex'>
              <div>Quantidade</div>
              <input type='number'></input>
            </label>

            <label className='labelFlex'>
              <div>Tipo</div>
              <input></input>
            </label>

            <label className='labelFlex'>
              <div>Motivo</div>
              <input></input>
            </label>

            <button type='submit'>Confirmar </button>
          </div>
          
        </form>
        
        
      </header>
    </div>
  );
}

export default App;
