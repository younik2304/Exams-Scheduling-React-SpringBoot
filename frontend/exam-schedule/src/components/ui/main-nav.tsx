import {Link} from "react-router-dom"

import { cn } from "@/lib/utils"
import React from "react";

export function MainNav({
                            className,
                            ...props
                        }: React.HTMLAttributes<HTMLElement>) {
    return (
        <nav
            className={cn("flex items-center space-x-4 lg:space-x-6", className)}
            {...props}
        >
            <Link
                to="/@/Dashboard"
                className="text-sm font-medium transition-colors hover:text-primary"
            >
                Overview
            </Link>
            <Link
                to="/@/Dashboard"
                className="text-sm font-medium text-muted-foreground transition-colors hover:text-primary"
            >
                Customers
            </Link>
            <Link
                to="/@/Dashboard"
                className="text-sm font-medium text-muted-foreground transition-colors hover:text-primary"
            >
                Products
            </Link>
            <Link
                to="/examples/dashboard"
                className="text-sm font-medium text-muted-foreground transition-colors hover:text-primary"
            >
                Settings
            </Link>
        </nav>
    )
}