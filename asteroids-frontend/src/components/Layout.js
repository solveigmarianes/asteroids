import {AppBar, Container, Toolbar, Typography} from "@mui/material";
import {Outlet} from "react-router-dom";

export default function Layout() {
    return (
        <>
            <header>
                <AppBar position="static">
                    <Toolbar>
                        <Typography variant="h6" noWrap component="h1">
                            Asteroids Near Earth
                        </Typography>
                    </Toolbar>
                </AppBar>
            </header>
            <main>
                <Container sx={{mt: 2}} maxWidth={false}>
                    <Outlet/>
                </Container>
            </main>
        </>
    )
}