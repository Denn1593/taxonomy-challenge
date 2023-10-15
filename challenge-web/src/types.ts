export type Type = {
    id: number,
    name: "BUILDING" | "CORPORATION" | "PROPERTY";
}

export type TreeNode = {
    id: number;
    children: TreeNode[];
    name: string;
    height: number;
    type: Type,
    zipCode?: number,
    monthlyRent?: number,
}