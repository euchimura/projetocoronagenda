function autenticar(event) {

    event.preventDefault(); //nao faça o comportamento padrão

    let usuario = document.getElementById("txtUsuario");
    let senha = document.getElementById("txtSenha");

    let loginMsg = {
        email: usuario.value,
        racf: usuario.value,
        senha: senha.value

    }

    let cabecalho = {
        method: 'POST',
        body: JSON.stringify(loginMsg),
        headers: {
            'Content-type': 'application/json'
        }
    }

    //envia pedido para o servidor e só continua quando chegar a resposta
    fetch('http://localhost:8080/login', cabecalho)
        .then(res => tratarResposta(res)); //arrow function chamando a funcao tratarResposta
}

function tratarResposta(res) {
    if (res.status == 200) {
        res.json().then(res => fazerLogin(res));
    } else {
        document.getElementById("msgErro").innerHTML = "Usuario/Senha inválidos.";
    }
}

function fazerLogin(res) {
    localStorage.setItem("userLogged", JSON.stringify(res));
    window.location = "relatorio.html";
}