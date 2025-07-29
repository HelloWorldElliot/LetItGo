import React, { useEffect, useState } from "react";
import axios from "axios";

const ItemList = () => {
  const [items, setItems] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem("token");

    axios
      .get("http://localhost:8080/api/items", {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      })
      .then((res) => setItems(res.data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <div>
      <h2>Available Items</h2>
      <ul>
        {items.map((item) => (
          <li key={item.id}>
            {item.title} - ${item.price}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ItemList;
