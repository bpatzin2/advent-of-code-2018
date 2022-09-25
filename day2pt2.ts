import * as fs from "fs"

const fileContent = fs.readFileSync("day2-input.txt", "utf-8")
const fileLines = fileContent.trim().split(/\r?\n/)
const result = findDifferentBy1Commonality(fileLines)
console.log(result)

function findDifferentBy1Commonality(strs: string[]): string | null {
  const lineLength = strs[0].length
  let i = 0
  while (i < lineLength) {
    const m = new Map<string, string>()
    let j = 0
    while (j < strs.length) {
      const line = strs[j]
      const edittedLine = removeCharAtIndex(line, i)
      const other = m.get(edittedLine)
      if (other != null) {
        return edittedLine
      }
      m.set(edittedLine, line)
      j++
    }
    i++
  }
  return null
}

function removeCharAtIndex(str: string, i: number): string {
  return str.slice(0, i) + str.slice(i + 1)
}
