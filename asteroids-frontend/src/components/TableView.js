import {Box, Paper, Skeleton, Stack, Typography} from "@mui/material";
import useGetRequest from "../hooks/useGetRequest";
import {useEffect} from "react";
import {DataGrid} from "@mui/x-data-grid";
import {useNavigate} from "react-router-dom";

export default function TableView() {
    const asteroidsRequest = useGetRequest("?startDate=2015-09-08")

    useEffect(() => {
        asteroidsRequest.execute()
    }, [])

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

    console.log(asteroidsRequest.data)
    return (
        <Asteroids asteroidResponse={asteroidsRequest.data} columns={columns}/>
    )
}

function Asteroids({asteroidResponse, columns}) {
    const navigate = useNavigate();
    if (asteroidResponse && asteroidResponse.nearEarthObjects) {
        return (
            <DataGrid
                autoHeight={true}
                columns={columns}
                rows={asteroidResponse.nearEarthObjects}
                onCellClick={(params, event) => {
                    event.defaultMuiPrevented = true
                }}
                onRowClick={(params) => {
                    navigate(`/${params.row.id}`)
                }}
            />)
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