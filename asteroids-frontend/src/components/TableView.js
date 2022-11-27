import {Paper} from "@mui/material";
import useGetRequest from "../hooks/useGetRequest";
import {useEffect} from "react";
import {DataGrid} from "@mui/x-data-grid";
import {useNavigate} from "react-router-dom";

export default function TableView() {
    const asteroidsRequest = useGetRequest("?startDate=2020-08-09")

    useEffect(() => {
        asteroidsRequest.execute()
    }, [])

    const columns = [
        {
            field: 'isPotentiallyHazardousAsteroid',
            headerName: 'Hazardous',
            sortable: true,
            valueGetter: params => params.row.potentially_hazardous_asteroid ? 'Yes' : 'No'
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
            field: 'relativeVelocity',
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
            field: 'estimatedDiameter',
            headerName: 'Estimated diameter (m)',
            width: 260,
            valueGetter: params => {
                const {meters} = params.row.estimated_diameter
                return `${meters.estimated_diameter_min} - ${meters.estimated_diameter_max}`
            }
        }
    ]

    return (
        <Paper sx={{width: '100%', height: '80rem'}}>
            <Asteroids asteroidResponse={asteroidsRequest.data} columns={columns}/>
        </Paper>
    )
}

function Asteroids({asteroidResponse, columns}) {
    const navigate = useNavigate();
    if (asteroidResponse && asteroidResponse.nearEarthObjects) {
        return (
            <DataGrid
                columns={columns}
                rows={asteroidResponse.nearEarthObjects}
                onCellClick={(params, event) => {
                    event.defaultMuiPrevented = true
                }}
                onRowClick={(params) => {
                    navigate(`/${params.row.id}`)
                }}
            />)
    } else return <></>
}