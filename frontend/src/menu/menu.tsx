import * as React from "react";
import "./menu.css"
import imagg from "../resources/soccer.png"

export const Menu = () => (
  <>
  <div className="menu">
    <li> <a className="item active" href="/">Map</a> </li>
    <li> <a className="item" href="/records">Records</a> </li>
  </div>
  <button className="menuButton"><img src={imagg}/></button>
 </> 
); 
