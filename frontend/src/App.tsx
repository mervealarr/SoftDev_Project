import { useState } from "react";
import WorklogForm from "./components/WorklogForm";
import Dashboard from "./components/Dashboard";

export default function App() {
  const [refreshKey, setRefreshKey] = useState(0);

  return (
    <div className="min-h-screen bg-zinc-900 text-white flex justify-center items-start py-10 px-4">
      <div className="w-full max-w-3xl space-y-10">
        <WorklogForm onSaved={() => setRefreshKey(k => k + 1)} />
        <Dashboard refreshKey={refreshKey} />
      </div>
    </div>
  );
}

