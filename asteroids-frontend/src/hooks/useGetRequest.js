import {useState} from "react";

const rootUrl = "http://localhost:8080/api/asteroids"

export default function useGetRequest(url) {
    const [isLoading, setIsLoading] = useState(true);
    const [error, setError] = useState(null);
    const [data, setData] = useState(null);

    const execute = async () => {
        setIsLoading(true)
        try {
            const result = await fetch(`${rootUrl}${url}`)
            const json = await result.json()
            setData(json);
        } catch (error) {
            setError(error)
        }
        setIsLoading(false)
    };

    return {isLoading, error, data, execute};
}