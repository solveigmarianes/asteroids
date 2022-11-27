import './App.css';
import {ThemeProvider, createTheme} from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import {Route, Routes} from "react-router-dom";
import Layout from "./components/Layout";
import TableView from "./components/TableView";
import DetailView from "./components/DetailView";

const darkTheme = createTheme({
    palette: {
        mode: 'dark',
    },
});

function App() {
    return (
        <ThemeProvider theme={darkTheme}>
            <CssBaseline/>
            <Routes>
                <Route path="/" element={<Layout />}>
                    <Route index element={<TableView />}/>
                    <Route path=":id" element={<DetailView />}/>
                </Route>
            </Routes>
        </ThemeProvider>
    );
}

export default App;
