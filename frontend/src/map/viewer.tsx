import React from 'react'
import {Ion, Cartesian3, Color } from 'cesium'
import { Viewer, Entity } from 'resium'
import "./viewer.css"


Ion.defaultAccessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiJmM2IzODQ0Ni02ZDc0LTQxMzQtYWNhMS04NDZlZTU4ZGI5OGEiLCJpZCI6Nzg1NTQsImlhdCI6MTY0MTM1NzkzN30.w9zdSVohPNFHNvUsom0x1vioCbP1uNiFmyvvIz3Z00U";

function MapView() {
  const mapViewer = <Viewer className='viewer'/>;

  return (
    mapViewer
  )
}

export default MapView