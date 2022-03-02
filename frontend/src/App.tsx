import NeverTileDiscardPolicy from 'cesium/Source/Scene/NeverTileDiscardPolicy';
import React from 'react'
import { Header } from './header/header';
import Records from './map/records';
import MapView from './map/viewer';
import Menu from './menu/menu';
import "./App.css";
import { MenuType } from './utils/Commons';

function App() {

  const [active, setActive] = React.useState(MenuType.MAP);

  function change(menu: MenuType) {
    setActive(menu);
  }

  function getPanel() {
    switch (active) {
      case MenuType.MAP:
        return <MapView />;
      case MenuType.RECORDS:
        return <Records />;
      default:
        return null;
    }
  }

  return (
    <div className='headerContainer'>
      <Header />
      <div className="bodyContainer">
        <Menu callback={change} activeMenu={active} />
        {getPanel()}
      </div>
    </div>
  )
}

export default App
