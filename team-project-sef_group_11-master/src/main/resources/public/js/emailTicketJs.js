const numberOfSeat = localStorage.getItem("count")

function onLoad(){
    document.getElementById("numberOfSeat").innerText = numberOfSeat.toString();
}