import axios from "axios";

const client = axios.create({
  baseURL: "/api"
});


export const getGrades       = () => client.get("/grades").then(r => r.data);
export const getEmployees    = () => client.get("/employees").then(r => r.data);
export const getWorklogTypes = () => client.get("/worklog-types").then(r => r.data);

export const postGrade       = (g: any) => client.post("/grades", g).then(r => r.data);
export const postEmployee    = (e: any) => client.post("/employees", e).then(r => r.data);
export const postWorklogType = (t: any) => client.post("/worklog-types", t).then(r => r.data);
export function postWorklog({
  engineerId,
  typeId,
  monthDate,
  effort
}: {
  engineerId: number;
  typeId: number;
  monthDate: string;
  effort: number;
}) {
  return axios.post("/api/worklogs", {
    employee: { id: engineerId },
    type: { id: typeId },
    monthDate,
    effort
  });
}


export const getDashboard    = () => client.get("/worklogs/dashboard").then(r => r.data);
