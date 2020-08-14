function validaLogin(){

    let userTxt = localStorage.getItem("userLogged");

    if(!userTxt){
        window.location = "index.html";
    }

    let jsonUser = JSON.parse(userTxt);

    document.getElementById("user").innerHTML = `${jsonUser.nome} ( ${jsonUser.racf} )` ;
    document.getElementById("imgUser").innerHTML = `<img src ="${jsonUser.linkFoto}">`;
    
    obterAgencias();
}

function logout(){
    localStorage.removeItem("userLogged");
    window.location = "index.html";
}

function obterAgencias(){
    fetch("http://localhost:8080/agencias")
    .then(res => res.json())
    .then(result => preencheAgencias(result));
}

function preencheAgencias(resposta){
    let agencias = '';

    for (let index = 0; index < resposta.length; index++) {
        agencias = agencias + `<option value = ${resposta[index].id}> ${resposta[index].nome} </option>`;
    }

    document.getElementById("sel_agencias").innerHTML = agencias;
}

function buscar(){
    let agencia = document.getElementById("sel_agencias");
    let agenciaId = agencia[agencia.selectedIndex].value; //obtem id da agencia selecionada 

    fetch("http://localhost:8080/agencia/"+agenciaId)
    .then(res => res.json())
    .then(result => preencheResposta(result));
}

function gerar(){
    let relAgencia = document.getElementById("selAgencia")
    let relData = document.getElementById("selData")
    let relCliente = document.getElementById("selCliente")

    //window.alert(relAgencia.checked+":"+relAgencia2.value+":"+relAgencia3.value)
    if (relAgencia.checked)
    {
       
        buscar();
    }

    if (relCliente.checked)
    {
        buscarNome();
    }
    
}
function buscarNome()
{
    let nomeCliente = document.getElementById("txtnome");
    let nome = nomeCliente.value;

//window.alert(nome)
fetch("http://localhost:8080/agendamento/cliente/"+nome)
    .then(res => res.json())
    .then(result => preencheRespostaNome(result));

}

function preencheRespostaNome(resposta){
    let tabela = '<table class = "table"> <tr> <th>Agencia</th> <th>data</th> <th>hora</th> </tr>';
   // window.alert("netrou")
   //let agencia = resposta[1].agencia
   // window.alert("Entrou: " +agencia.nome)
  window.alert("Entrou: " +resposta[0].dataAgendamento)
   for (let index = 0;index<resposta.length;index++){
        tabela = tabela + `<tr> <td> ${resposta[index].agencia.nome} </td> 
                            <td> ${resposta[index].dataAgendamento} </td>
                            <td> ${resposta[index].horaAgendamento} </td> </tr>`;

    }
    tabela = tabela +'</table>';
    document.getElementById("tableResposta").innerHTML = tabela;
}

function preencheResposta(resposta){
    window.alert("entrou");
    let agendas = '<table class = "table"> <tr> <th>cliente</th> <th>data</th> <th>hora</th> </tr>';

    for (let index = 0; index < resposta.agendamentos.length; index++) {
        agendas = agendas + `<tr> <td> ${resposta.agendamentos[index].nome} </td> 
                                  <td> ${resposta.agendamentos[index].dataAgendamento} </td>
                                  <td> ${resposta.agendamentos[index].horaAgendamento} </td> </tr>`;
    }

    agendas = agendas + '</table>';

    document.getElementById("tableResposta").innerHTML = agendas;
}