const API_URL = "https://vizioon-todoist-java-backend.onrender.com/api/tarefa";

let tarefas = [];

const listEl = document.getElementById("lista-tarefas");
const contadorEl = document.getElementById("contador");
const statusEl = document.getElementById("status-api");
const formEl = document.getElementById("formulario-tarefa");
const campoEl = document.getElementById("campo-tarefa");
const botaoAdicionarEl = document.getElementById("botao-adicionar");

async function buscarTarefas() {
  statusEl.textContent = "Conectando a API... (Isso pode demorar um pouco)";
  statusEl.classList = "error";

  try {
    const response = await fetch(API_URL);

    if (!response.ok) {
      throw new Error("Erro ao buscar tarefas");
    }

    const dados = await response.json();

    tarefas = dados.map(item => ({
        id: item.id,
        text: item.nome,
        concluida: false
    }))
    statusEl.textContent = "Conectado a API"
    renderizarTarefas()
  } catch (error) {}
}

function renderizartarefas() {
    listEl.innerHTML = ""
    
    if(tarefas.length === 0) {
        listEl.innerHTML = "<li>Nenhuma tarefa encontrada</li>"
    }

    tarefas.forEach((tarefa) => {
        const item = document.createElement("li");
        item.innerHTML = `
            <span>V</span>
            <span>${tarefa.texto}</span>
            <button>X</button>`;
    })
}


