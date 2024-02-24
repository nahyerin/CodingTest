const fs = require("fs");
const input = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `100 99 1000000000`
)
  .trim()
  .split(" ");

let up = Number(input[0]);
let down = Number(input[1]);
let totalMeter = Number(input[2]);
let days = 0;

days = Math.ceil((totalMeter - down) / (up - down));

console.log(days);