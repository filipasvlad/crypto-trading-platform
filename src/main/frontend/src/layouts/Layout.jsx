import {Outlet} from 'react-router-dom';
import Navbar from '../components/navbar/Navbar';
import Footer from "../components/footer/Footer.jsx";
import styles from "./Layout.module.css"

function Layout() {
    return (
        <div className={styles.layoutContainer}>
            <Navbar/>
            <main className={styles.layoutMain}>
                <Outlet/>
            </main>
            <Footer/>
        </div>
    );
}

export default Layout;