import { useEffect, useState } from 'react'

import './App.css'
import { Node } from './components/Node'
import type { TreeNode } from './types';

function App() {
  const [rootNode, setRootNode] = useState<TreeNode | null>(null);

  const [nodeId, setNodeId] = useState("");
  const [parentId, setParentId] = useState("");

  const [error, setError] = useState<string>();

  const fetchNodes = async () => {
    setError("");
    console.log(import.meta.env.VITE_URL + "/api/v1/node/1");
    const response = await fetch("http://" + import.meta.env.VITE_URL + "/api/v1/node/1");

    if (!response.ok) {
      setError('Could not fetch nodes');
      return;
    }

    const node = await response.json();
    setRootNode(node)
  }

  const changeNodes = async (id: string, parentId: string) => {
    setError("");
    const response = await fetch("http://" + import.meta.env.VITE_URL + "/api/v1/node/" + id + "/parent/" + parentId, { method: 'PUT' });

    if (!response.ok) {
      setError("Could not change nodes.");
      return;
    }

    fetchNodes();
  }

  useEffect(() => {
    fetchNodes();
  }, [])

  return (
    <>
      {
        error && (
          <p className='error'>{error}</p>
        )
      }
      <div className='header'>
        <p>From</p>
        <input type='text' value={nodeId} onChange={(e) => setNodeId(e.target.value)} />
        <p>To</p>
        <input type='text' value={parentId} onChange={(e) => setParentId(e.target.value)} />
        <button onClick={() => changeNodes(nodeId, parentId)}>Change</button>
      </div>

      {
        rootNode && (
          <Node node={rootNode} />
        )
      }

    </>
  )
}

export default App
