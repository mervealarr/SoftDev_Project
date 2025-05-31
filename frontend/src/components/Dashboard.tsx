import { useEffect, useState } from "react";
import { getDashboard } from "../services/api";

interface Stat {
  label: string;
  totalEffort: number;
  children?: Stat[];
}

interface DashboardDto {
  byEmployee: Stat[];
  byTeamLead: Stat[];
  byDirector: Stat[];
  byGrade: Stat[];
  byWorklogType: Stat[];
}

export default function Dashboard({ refreshKey }: { refreshKey: number }) {
  const [data, setData] = useState<DashboardDto | null>(null);

  useEffect(() => {
    getDashboard().then(setData);
  }, [refreshKey]);

  if (!data) return <div>Loading...</div>;

  return (
      <div className="w-full max-w-3xl px-4">
        <h2 className="text-2xl font-bold text-center mb-6">Time Tracking Summary</h2>

        <h3 className="text-xl font-semibold mt-4">By Director</h3>
        <ul className="ml-4 list-disc">
          {data.byDirector.map(d => (
            <li key={d.label}>{d.label} – {d.totalEffort} hrs</li>
          ))}
        </ul>

        <h3 className="text-xl font-semibold mt-6">By Team Lead</h3>
        <ul className="ml-4 list-disc">
          {data.byTeamLead.map(tl => (
            <li key={tl.label}>
              {tl.label} – {tl.totalEffort} hrs
              <ul className="ml-6 list-circle">
                {tl.children?.map(emp => (
                  <li key={emp.label}>↳ {emp.label}: {emp.totalEffort} hrs</li>
                ))}
              </ul>
            </li>
          ))}
        </ul>

        <h3 className="text-xl font-semibold mt-6">By Employee</h3>
        <ul className="ml-4 list-disc">
          {data.byEmployee.map(e => (
            <li key={e.label}>{e.label}: {e.totalEffort} hrs</li>
          ))}
        </ul>

        <h3 className="text-xl font-semibold mt-6">By Grade</h3>
        <ul className="ml-4 list-disc">
          {data.byGrade.map(g => (
            <li key={g.label}>{g.label}: {g.totalEffort} hrs</li>
          ))}
        </ul>

        <h3 className="text-xl font-semibold mt-6">By Worklog Type</h3>
        <ul className="ml-4 list-disc">
          {data.byWorklogType.map(wt => (
            <li key={wt.label}>{wt.label}: {wt.totalEffort} hrs</li>
          ))}
        </ul>
      </div>
    );
}