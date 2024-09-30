import React, { useState } from 'react';

const AccountRegistrationPage = () => {
  const [accountData, setAccountData] = useState({
    name: '',
    value: '',
    dueDate: '',
    status: 'pendente',
    registrationDate: new Date().toISOString().split('T')[0] // Data atual
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setAccountData({
      ...accountData,
      [name]: value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Aqui você pode fazer a chamada de API para cadastrar a conta
    console.log('Account Data: ', accountData);
  };

  return (
    <div>
      <h2>Cadastro de Conta</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="name"
          placeholder="Nome da Conta"
          value={accountData.name}
          onChange={handleChange}
          required
        />
        <input
          type="number"
          name="value"
          placeholder="Valor"
          value={accountData.value}
          onChange={handleChange}
          required
        />
        <input
          type="date"
          name="dueDate"
          placeholder="Data de Vencimento"
          value={accountData.dueDate}
          onChange={handleChange}
          required
        />
        <select
          name="status"
          value={accountData.status}
          onChange={handleChange}
          required
        >
          <option value="pendente">Pendente</option>
          <option value="paga">Paga</option>
        </select>
        <button type="submit">Cadastrar Conta</button>
      </form>
    </div>
  );
};

export default AccountRegistrationPage;
