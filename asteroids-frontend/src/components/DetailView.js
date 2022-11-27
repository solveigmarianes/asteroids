import useGetRequest from "../hooks/useGetRequest";
import {useParams} from "react-router-dom";
import {useEffect} from "react";
import {Box, Divider, Paper, Skeleton, Stack, Typography} from "@mui/material";
import {Link as MuiLink} from "@mui/material";
import {DataGrid} from "@mui/x-data-grid";

export default function DefaultView() {
    const {id} = useParams()
    const asteroidRequest = useGetRequest(`/${id}`)
    useEffect(() => {
        asteroidRequest.execute()
    }, [])

    if (asteroidRequest.data) {
        const asteroid = asteroidRequest.data

        return (
            <>
                <MuiLink href="/">Back to overview</MuiLink>
                <Paper sx={{p: 2, mt: 2}}>
                    <Typography variant="overline">
                        NEO reference ID: {asteroid.neo_reference_id}
                    </Typography>
                    <Typography variant="h2">
                        {asteroid.designation || asteroid.name}
                    </Typography>
                    <Divider sx={{mt: 2, mb: 2}}/>
                    <Stack direction="row" spacing={4}>
                        <div>
                            <Typography variant="overline">
                                Potenially hazardous
                            </Typography>
                            <Typography sx={{fontSize: "large"}}>
                                {asteroid.is_potentially_hazardous_asteroid ? "Yes" : "No"}
                            </Typography>
                        </div>
                        <div>
                            <Typography variant="overline">
                                Sentry object
                            </Typography>
                            <Typography sx={{fontSize: "large"}}>
                                {asteroid.is_sentry_object ? "Yes" : "No"}
                            </Typography>
                        </div>
                        <div>
                            <Typography variant="overline">
                                Estimated diameter in meters
                            </Typography>
                            <Typography sx={{fontSize: "large"}}>
                                {Number.parseFloat(asteroid.estimated_diameter.meters.estimated_diameter_min).toFixed(3)} m
                                - {Number.parseFloat(asteroid.estimated_diameter.meters.estimated_diameter_max).toFixed(3)} m
                            </Typography>
                        </div>
                    </Stack>
                </Paper>
                <CloseApproachTable data={asteroid.close_approach_data}/>
            </>
        )
    } else return <SkeletonView/>
}

function CloseApproachTable({data}) {
    const columns = [
        {
            field: 'close_approach_date',
            headerName: 'Date',
            type: 'date',
            sortable: true,
            valueGetter: params => new Date(params.row.close_approach_date)
        },
        {
            field: 'orbiting_body',
            headerName: 'Orbiting body',
            width: 110,
            sortable: true
        },
        {
            field: 'miss_distance.kilometers',
            headerName: 'Miss distance (km)',
            width: 150,
            type: 'number',
            valueGetter: params => params.row.miss_distance.kilometers
        },
        {
            field: 'relative_velocity.kilometers_per_hour',
            headerName: 'Relative velocity (km/h)',
            width: 170,
            type: 'number',
            valueGetter: params => params.row.relative_velocity.kilometers_per_hour
        }
    ]

    return (
        <Box sx={{mt: 4, mb: 4}}>
            <Typography variant="h4" sx={{mt: 2, mb: 2}}>Close approaches</Typography>
            <DataGrid
                autoHeight={true}
                columns={columns}
                rows={data}
                getRowId={(row) => row.epoch_date_close_approach}
                onCellClick={(params, event) => {
                    event.defaultMuiPrevented = true
                }}
            />
        </Box>
    )
}

function SkeletonView() {
    return (
        <>
            <MuiLink href="/">Back to overview</MuiLink>
            <Paper sx={{p: 2, mt: 2}}>
                <Typography variant="overline">
                    NEO reference ID: <Skeleton sx={{display: 'inline-flex', width: '6rem'}}/>
                </Typography>
                <Typography variant="h2">
                    <Skeleton/>
                </Typography>
                <Divider sx={{mt: 2, mb: 2}}/>
                <Stack direction="row" spacing={4}>
                    <div>
                        <Typography variant="overline">
                            Potenially hazardous
                        </Typography>
                        <Skeleton sx={{fontSize: 'large'}}/>
                    </div>
                    <div>
                        <Typography variant="overline">
                            Sentry object
                        </Typography>
                        <Typography sx={{fontSize: "large"}}>
                            <Skeleton sx={{fontSize: 'large'}}/>
                        </Typography>
                    </div>
                    <div>
                        <Typography variant="overline">
                            Estimated diameter in meters
                        </Typography>
                        <Skeleton sx={{fontSize: 'large'}}/>
                    </div>
                </Stack>
            </Paper>
            <Box sx={{mt: 4, mb: 4}}>
                <Typography variant="h4" sx={{mt: 2, mb: 2}}>Close approaches</Typography>
                <Stack spacing={1}>
                    <Skeleton variant="rectangular" height={48}/>
                    <Skeleton variant="rectangular" height={48}/>
                    <Skeleton variant="rectangular" height={48}/>
                    <Skeleton variant="rectangular" height={48}/>
                </Stack>
            </Box>
        </>
    )
}