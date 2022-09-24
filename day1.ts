import * as fs from 'fs';

const allFileContents = fs.readFileSync('day1-input.txt', 'utf-8');
const numbersStrs = allFileContents.trim().split(/\r?\n/)

const result = numbersStrs
  .map(x => x.replace("+", ""))
  .map(x => parseInt(x))
  .reduce((a, b) => a + b)

console.log(result)  

