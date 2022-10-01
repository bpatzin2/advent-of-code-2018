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
  id: string
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
    let ids = result.get(key)
    if (ids == null) {
      ids = []
    } 
    ids.push(claim.id)
    result.set(key, ids)
  })

  return result
}, new Map<string, string[]>())

const claimsById = new Map(
  claims.map(claim => {
    return [claim.id, claim];
  }),
);

Array.from(claimsPerCoord.values()).forEach(claimIds => {
  if(claimIds.length > 1){
    claimIds.forEach(claimId => claimsById.delete(claimId))
  }
});  

const result = claimsById.keys().next().value
console.log(result)

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
    const id = line.substring(0, line.indexOf("@"))

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

    return { id, startCoord, dims }
  })
}
