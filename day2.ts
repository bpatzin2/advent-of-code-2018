import * as fs from 'fs';

const fileContent = fs.readFileSync('day2-input.txt', 'utf-8');
const fileLines = fileContent.trim().split(/\r?\n/)

const counts = fileLines.map(x => {
  const charList = x.split("")
  const occurrences = countOccurrences(charList)
  return {
    has2: !![...occurrences.values()].find(x => x === 2),
    has3: !![...occurrences.values()].find(x => x === 3)
  }
})

const twoCounts = counts.filter(x => x.has2).length
const threeCounts = counts.filter(x => x.has3).length
const result = twoCounts * threeCounts

console.log(result)

function countOccurrences<T>(list: T[]): Map<T, number> {
  return list.reduce(function (acc, curr) {
    const count = acc.get(curr) || 0
    acc.set(curr, count + 1)
    return acc
  }, new Map<T, number>());
}
