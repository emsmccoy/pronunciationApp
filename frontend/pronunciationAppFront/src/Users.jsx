import { useState, useEffect } from "react";

import { fetchUsers } from "./data-api";

export default function Users() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    const getUsers = async () => {
      try {
        const data = await fetchUsers();
        setUsers(data);
      } catch (error) {
        console.error("Failed to fetch words:", error);
      }
    };

    getUsers();
  }, []);

  const user = users.find((user) => (user.id === "3"))

  return (
    //<>
    //<h1>Users</h1>
    //{ users.map((user) => (<h1> {user.name} </h1>))} 
    //</>
    <>
      <h1>{ user.name }</h1>
    </>
  );
}