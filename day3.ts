import * as fs from "fs"

type Coord = {
  x: number
  y: number
}

type Dimensions = {
  width: number
  height: number
}

type Claim = {
  startCoord: Coord
  dims: Dimensions
}

const fileContent = fs.readFileSync("day3-input.txt", "utf-8")
const fileLines = fileContent.trim().split(/\r?\n/)

const claims = parse(fileLines)
const claimsPerCoord = claims.reduce((result, claim) => {
  const coords = getCoords(claim)
  coords.forEach(coord => {
    const key = coordStr(coord)
    const count = result.get(key)
    if (count != null) {
      result.set(key, count + 1)
    } else {
      result.set(key, 1)
    }
  })

  return result
}, new Map<string, number>())

const numMultipleClaims = Array.from(claimsPerCoord.values()).filter(
  count => count > 1
).length

console.log(numMultipleClaims)

function getCoords(claim: Claim): Coord[] {
  const result = []
  const xMin = claim.startCoord.x
  const xMax = xMin + claim.dims.width
  const yMin = claim.startCoord.y
  const yMax = yMin + claim.dims.height
  for (let x = xMin; x < xMax; x++) {
    for (let y = yMin; y < yMax; y++) {
      result.push({ x, y })
    }
  }
  return result
}

function coordStr(coord: Coord): string {
  return `${coord.x}:${coord.y}`
}

function parse(fileLines: string[]): Claim[] {
  return fileLines.map(line => {
    const startCoordString = line.substring(
      line.indexOf("@") + 2,
      line.indexOf(":")
    )
    const dimsString = line.substring(line.indexOf(":") + 2)

    const startCoord = {
      x: parseInt(startCoordString.substring(0, startCoordString.indexOf(","))),
      y: parseInt(
        startCoordString.substring(startCoordString.indexOf(",") + 1)
      ),
    }

    const dims = {
      width: parseInt(dimsString.substring(0, dimsString.indexOf("x"))),
      height: parseInt(dimsString.substring(dimsString.indexOf("x") + 1)),
    }

    return { startCoord, dims }
  })
}
