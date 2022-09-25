import * as fs from "fs"

const changes = getChangesFromFile()
const result = firstDuplicateFrequency(changes)
console.log(result)

function firstDuplicateFrequency(changes: number[]) {
  let frequency = 0
  const frequencies = new Set<number>([frequency])
  let i = 0
  // eslint-disable-next-line no-constant-condition
  while (true) {
    const change = changes[i]
    frequency += change
    if (frequencies.has(frequency)) {
      return frequency
    }
    frequencies.add(frequency)

    i++
    if (i == changes.length) {
      i = 0
    }
  }
}

function getChangesFromFile() {
  const allFileContents = fs.readFileSync("day1-input.txt", "utf-8")
  const numbersStrs = allFileContents.trim().split(/\r?\n/)
  return numbersStrs.map(x => x.replace("+", "")).map(x => parseInt(x))
}
