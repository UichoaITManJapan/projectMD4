function changeDirection(){
    let direction = document.getElementById("direction").value;
    window.location="findProduct?direction="+direction;
}
function changeSortBy(){
    let sortBy = document.getElementById("sortBy").value;
    //Gọi controller
    window.location="findProduct?sortBy="+sortBy;
}
