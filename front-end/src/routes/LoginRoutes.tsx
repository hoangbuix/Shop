import React, { lazy, Suspense } from "react"
import { Route, Switch } from "react-router-dom"
import Loading from "../components/UiLoading"
import { PATH } from "../constants/paths"
const Login = lazy(() => import("../pages/auth/Login"))

export default function LoginRoutes() {
    return (
        <Switch>
            <Route
                path={PATH.LOGIN}
                component={() => (
                    <Suspense fallback={<Loading />}>
                        <Login />
                    </Suspense>
                )}
            />
        </Switch>
    )
}