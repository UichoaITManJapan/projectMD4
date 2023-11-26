function changeDirection(){
    let direction = document.getElementById("direction").value;
    window.location="findAccounts?direction="+direction;
}
function changeSortBy(){
    let sortBy = document.getElementById("sortBy").value;
    //Gọi controller
    window.location="findAccounts?sortBy="+sortBy;
}