import { SimInfo } from 'cap-sim-info';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    SimInfo.echo({ value: inputValue })
}
