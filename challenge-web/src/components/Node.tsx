import React from 'react';
import { TreeNode } from "../types"

type Props = {
    node: TreeNode;
}

export const Node: React.FC<Props> = ({ node }) => {


    return <div className="node">
        <p>Id {node.id}</p>
        <p>Name {node.name}</p>
        <p>Height {node.height}</p>
        <p>Name {node.type.name}</p>
        {node.zipCode && <p>Zipcode {node.zipCode}</p>}
        {node.monthlyRent && <p>Monthly Rent {node.monthlyRent}</p>}

        <div className='children'>
            {
                node.children.map((child) => <Node node={child} />)
            }
        </div>
    </div>
}