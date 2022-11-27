import {Alert, Box, Button, Paper, Skeleton, Snackbar, Stack, TextField, Toolbar, Typography} from "@mui/material";
import useGetRequest from "../hooks/useGetRequest";
import {useEffect, useState} from "react";
import {DataGrid} from "@mui/x-data-grid";
import {useNavigate} from "react-router-dom";

export default function TableView() {
    const [date, setDate] = useState("2022-11-01")
    const [url, setUrl] = useState(`?startDate=${date}`)

    const onChange = event => setDate(event.target.value)

    const handleSubmit = event => {
        event.preventDefault()
        setUrl(`?startDate=${date}`)
    }

    return (
        <>
            <Paper sx={{p: 2, mt: 2}}>
                <Stack direction="row" spacing={2} sx={{alignItems: 'center', justifyContent: 'flex-end'}}>
                    <Box sx={{width: '80%'}}>
                        <Typography variant="overline" component="p">
                            Can you spot the next disaster?
                        </Typography>
                        <Typography component="p">
                            Find asteroids near Earth one week from date:
                        </Typography>
                    </Box>
                    <TextField
                        id="startDate"
                        label="Start date"
                        type="date"
                        defaultValue={date}
                        sx={{width: 220}}
                        variant="filled"
                        InputLabelProps={{
                            shrink: true,
                        }}
                        onChange={onChange}
                    />
                    <Button onClick={handleSubmit} variant="contained">Find asteroids</Button>
                </Stack>
            </Paper>
            <Paper>
                <AsteroidsTable url={url}/>
            </Paper>
        </>
    )
}

function AsteroidsTable({url}) {
    const asteroidsRequest = useGetRequest(url)
    const {data} = asteroidsRequest
    const navigate = useNavigate();

    useEffect(() => {
        asteroidsRequest.execute()
    }, [url])


    const columns = [
        {
            field: 'is_potentially_hazardous_asteroid',
            headerName: 'Hazardous',
            sortable: true,
            valueGetter: params => params.row.is_potentially_hazardous_asteroid ? 'Yes' : 'No'
        },
        {
            field: 'id',
            headerName: 'ID',
        },
        {
            field: 'name',
            headerName: 'Name',
            width: 170
        },
        {
            field: 'distance',
            headerName: 'Distance (km)',
            width: 120,
            sortable: true,
            type: 'number',
            valueGetter: (params) => {
                const {close_approach_data} = params.row
                if (close_approach_data && close_approach_data.length) {
                    const {miss_distance} = close_approach_data[0]
                    if (miss_distance) {
                        return miss_distance.kilometers
                    }
                } else return 'Unknown'
            }
        },
        {
            field: 'relative_velocity',
            headerName: 'Relative velocity (km/h)',
            width: 170,
            sortable: true,
            type: 'number',
            valueGetter: params => {
                const {close_approach_data} = params.row
                if (close_approach_data && close_approach_data.length) {
                    const {relative_velocity} = close_approach_data[0]
                    return relative_velocity.kilometers_per_hour
                }
            }
        },
        {
            field: 'estimated_diameter',
            headerName: 'Estimated diameter (m)',
            width: 260,
            valueGetter: params => {
                const {meters} = params.row.estimated_diameter
                return `${Number.parseFloat(meters.estimated_diameter_max).toFixed(3)} m - ${Number.parseFloat(meters.estimated_diameter_max).toFixed(3)} m`
            }
        }
    ]

    if (data && data.nearEarthObjects) {
        return (
            <Box sx={{mt: 2, mb: 4}}>
                <DataGrid
                    autoHeight={true}
                    columns={columns}
                    rows={data.nearEarthObjects}
                    onCellClick={(params, event) => {
                        event.defaultMuiPrevented = true
                    }}
                    onRowClick={(params) => {
                        navigate(`/${params.row.id}`)
                    }}
                />
                <Snackbar
                    open={asteroidsRequest.isLoading}
                    autoHideDuration={6000}
                    anchorOrigin={{vertical: 'top', horizontal: 'right'}}
                >
                    <Alert severity="info">Reloading asteroids, please wait...</Alert>
                </Snackbar>
            </Box>
        )
    } else return (
        <Box sx={{mt: 4, mb: 4}}>
            <Stack spacing={1}>
                <Skeleton variant="rectangular" height={48}/>
                <Skeleton variant="rectangular" height={48}/>
                <Skeleton variant="rectangular" height={48}/>
                <Skeleton variant="rectangular" height={48}/>
            </Stack>
        </Box>
    )
}