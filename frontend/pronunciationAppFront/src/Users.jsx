import { useState, useEffect } from "react";

import { fetchUsers } from "./data-api";

import { 
  Card, 
  CardHeader, 
  Avatar, 
  CardContent, 
  Typography, 
  Chip,
  Box 
} from '@mui/material';

export default function Users() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    const getUsers = async () => {
      try {
        const data = await fetchUsers();
        setUsers(data);
      } catch (error) {
        console.error("Failed to fetch users:", error);
      }
    };

    getUsers();
  }, []);

  const user = users.find((user) => (user.id === "1"));

  const getInitials = (name) => {
    return name.split(' ').map(part => part[0]).join('').toUpperCase();
  };

  return (
    <Box 
      display="flex" 
      justifyContent="center" 
      alignItems="center" 
    >      
    {user ? (
      <Card sx={{ maxWidth: 345, m: 7 }}>
        <CardHeader
          avatar={
            <Avatar 
              src={`src/assets/profile.webp`}
              sx={{ width: 150, height: 150 }}
              aria-label="user avatar"
            >
              {getInitials(user.name)}
            </Avatar>
          }
          title={
          <>
          <Typography variant="h5">
            {user.name}
          </Typography>
          </>
          }
          subheader={
            <>
              <Typography variant="subtitle1">
                {user.age} years old
              </Typography>
              <Chip 
                label={user.isActive ? "Active" : "Inactive"} 
                size="small" 
                color={user.isActive ? "success" : "error"}
                sx={{ mt: 0.5 }}
              />
            </>
          }
        />
        
        <CardContent>
          <Typography variant="body2" sx={{ mb: 1.5 }}>
            <strong>Email:</strong>{" "}
              {user.email}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            <strong>Member since:</strong>{" "}
              {user.joinDate}
          </Typography>
        </CardContent>

      </Card>
    ) : (
      <Typography variant="h6" sx={{ p: 3 }}>
        Loading user data...
      </Typography>
    )}
  </Box>
);
}