
import React, { useEffect, useState, FormEvent } from "react";
import { getEmployees, getWorklogTypes, postWorklog } from "../services/api";

interface Employee {
  id: number;
  firstName: string;
  lastName: string;
}

interface WorklogType {
  id: number;
  name: string;
}

export default function WorklogForm({ onSaved }: { onSaved: () => void }) {
  const [employees, setEmployees] = useState<Employee[]>([]);
  const [types, setTypes] = useState<WorklogType[]>([]);
  const [engineerId, setEngineerId] = useState<number>();
  const [typeId, setTypeId] = useState<number>();
  const [monthDate, setMonthDate] = useState<string>("");
  const [effort, setEffort] = useState<number>(0);

  useEffect(() => {
    getEmployees().then(setEmployees);
    getWorklogTypes().then(setTypes);
  }, []);

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    if (!engineerId || !typeId || !monthDate || effort <= 0) return;

    postWorklog({
      engineerId: engineerId!,
      typeId: typeId!,
      monthDate,
      effort
    }).then(() => {
      onSaved(); // Dashboard'u güncelle
      setEngineerId(undefined);
      setTypeId(undefined);
      setMonthDate("");
      setEffort(0);
    });
  };

  return (
    <form onSubmit={handleSubmit} className="p-4 border rounded space-y-4">
      <h2 className="text-lg font-semibold">New Worklog</h2>

      <div className="flex flex-col">
        <label className="mb-1 font-medium">Engineer</label>
        <select
          className="border rounded px-2 py-1"
          value={engineerId ?? ""}
          onChange={e => setEngineerId(+e.target.value)}
          required
        >
          <option value="" disabled>Select engineer</option>
          {employees.map(emp => (
            <option key={emp.id} value={emp.id}>
              {emp.firstName} {emp.lastName}
            </option>
          ))}
        </select>
      </div>

      <div className="flex flex-col">
        <label className="mb-1 font-medium">Worklog Type</label>
        <select
          className="border rounded px-2 py-1"
          value={typeId ?? ""}
          onChange={e => setTypeId(+e.target.value)}
          required
        >
          <option value="" disabled>Select type</option>
          {types.map(t => (
            <option key={t.id} value={t.id}>
              {t.name}
            </option>
          ))}
        </select>
      </div>

      <div className="flex flex-col">
        <label className="mb-1 font-medium">
          Month <span className="text-sm text-gray-400">(e.g. 2025-05)</span>
        </label>
        <input
          type="month"
          className="border rounded px-2 py-1"
          value={monthDate}
          onChange={e => setMonthDate(e.target.value)}
          required
          placeholder="YYYY-MM"
        />
      </div>

      <div className="flex flex-col">
        <label className="mb-1 font-medium">Effort (hours)</label>
        <input
          type="number"
          className="border rounded px-2 py-1 w-24"
          value={effort}
          onChange={e => setEffort(+e.target.value)}
          min={1}
          required
        />
      </div>

      <div className="text-right">
        <button
          type="submit"
          className="bg-blue-600 hover:bg-blue-700 text-white px-4 py-1 rounded"
        >
          Save
        </button>
      </div>
    </form>
  );
}
