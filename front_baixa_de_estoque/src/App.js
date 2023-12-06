import './App.css';
import React, {useEffect, useState} from 'react'
import api from './api';
import axios from 'axios'

function formatDate(date) {
  const year = date.getFullYear();
  const month = String(date.getMonth() + 1).padStart(2, '0');
  const day = String(date.getDate()).padStart(2, '0');

  return `${year}-${month}-${day}`;
}

function App() {
  
  const[Produto, setProduto] = useState();
  const[produtos, setProdutos] = useState([]);
  const[Quantidade, setQuantidade] = useState();
  const[Tipo, setTipo] = useState();
  const[Motivo, setMotivo] = useState('')
  const motivos=['VENDIDO','QUEBRADO','OUTROS'];
  
  const handleProdutoChange=(event)=>{
    setProduto(event.target.value)
  }

  const handleQuantidadeChange=(event)=>{
    setQuantidade(event.target.value)
  }

  const handleTipoChange=(event)=>{
    setTipo(event.target.value)
  }

  const handleMotivoChange=(event)=>{
    setMotivo(event.target.value)
  }

  useEffect(()=>{
    const fetchData = async () => {
      try {
        const responseP = await axios.get("http://localhost:8080/produto")
        const dataProduto = responseP.data;
        console.log(dataProduto)
        setProdutos(dataProduto)  
      }
      catch(error){
        alert("Erro Interno");
        console.log(error);
      }
    };
    fetchData();
  },[]);

  const handleSubmit = (event) => {
    event.preventDefault();
    

    axios.post("http://localhost:8080/acerto",{
      codigoProduto: Produto,
      quantidade: Quantidade ,
      tipo: Tipo,
      motivo: Motivo,
      data: formatDate(new Date())
    }).then(()=>{
      alert("Acerto feito")
      window.location.reload(true)
    }).catch((error) =>{
      alert(error)
      console.log(error.data)
    })
  }

  return (
    <div className="App">
      <header className="App-header"
      > <h2>Acerto</h2>
        <form onSubmit={handleSubmit} className='containerFlex'>
          <div className='Formulario'>
            <div className='labelFlex'> 
              <label>
                <div>Produto</div>
                <select value={Produto} onChange={handleProdutoChange} required={true}>
                <option value="">Selecione o id</option>{
                  produtos.map((option, index) =>(
                    <option key={index} value={option.id}>
                      {option.id}
                    </option>
                  ))
                }
                </select>
              </label>
            </div>

            <div className='labelFlex'>
              <label>
                <div>Quantidade</div>
                <input value={Quantidade} onChange={handleQuantidadeChange} required={true} type='number'></input>
              </label>
            </div>

            <div className='labelFlex'>
              <label>
                <div>Tipo</div>
                <input type='text' value={Tipo} onChange={handleTipoChange} required={true}></input>
                
              </label>
            </div>

            <div className='labelFlex'>
              <label>
                <div>Motivo</div>
                <select value={Motivo} onChange={handleMotivoChange}>
                <option value="">Selecione</option>{
                  motivos.map((option, index) =>(
                    <option key={index} value={option}>
                      {option}
                    </option>
                  ))
                }
                </select>
              </label>
            </div>

            <button type='submit'>Confirmar </button>
          </div>
          
        </form>
        
        
      </header>
    </div>
  );
}

export default App;
