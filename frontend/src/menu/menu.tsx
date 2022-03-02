import * as React from "react";
import "./menu.css"
import imagg from "../resources/soccer.png"
import { MenuType } from "../utils/Commons";

type MenuProps = {
    callback: Function,
    activeMenu: MenuType
}


function Menu(props: MenuProps) {

  function menuUpdated(active:MenuType)
  {
    props.callback(active);
  }

  function isActive(selected:MenuType): string
  {
      if(selected === props.activeMenu)
      {
        return "item active";
      }
      return "item";

  }

  return (
  <>
  <div className="menu">
    <li> <a className={props.activeMenu == MenuType.MAP ? "item active" : "item"}  href="#" onClick={() => menuUpdated(MenuType.MAP)}>Map</a> </li>
    <li> <a className={props.activeMenu == MenuType.RECORDS ? "item active" : "item"}  href="#" onClick={() => menuUpdated(MenuType.RECORDS)}>Records</a> </li>
  </div>
  {/* <button className="menuButton"><img src={imagg}/></button> */}
 </> )

  }

  export default Menu