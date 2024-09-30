// AccountManagementPage.js
import React, { useState } from 'react';

const AccountManagementPage = () => {
  const [accounts, setAccounts] = useState([
    // Exemplo de dados, que podem ser substituídos por uma chamada de API
    {
      id: 1,
      name: 'Conta de Luz',
      value: 200.00,
      dueDate: '2024-09-30',
      status: 'pendente',
      registrationDate: '2024-09-01'
    },
    {
      id: 2,
      name: 'Aluguel',
      value: 1200.00,
      dueDate: '2024-10-05',
      status: 'paga',
      registrationDate: '2024-09-01'
    }
  ]);

  const handleEdit = (id) => {
    // Aqui você implementa a lógica de edição, por exemplo abrindo um modal
    console.log('Edit Account ID: ', id);
  };

  const handleDelete = (id) => {
    // Lógica para excluir uma conta
    setAccounts(accounts.filter(account => account.id !== id));
  };

  const handleStatusChange = (id, newStatus) => {
    setAccounts(accounts.map(account => 
      account.id === id ? { ...account, status: newStatus } : account
    ));
  };

  return (
    <div>
      <h2>Gerenciamento de Contas</h2>
      <table>
        <thead>
          <tr>
            <th>Nome da Conta</th>
            <th>Valor</th>
            <th>Data de Vencimento</th>
            <th>Status</th>
            <th>Data de Cadastro</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {accounts.map(account => (
            <tr key={account.id}>
              <td>{account.name}</td>
              <td>{account.value}</td>
              <td>{account.dueDate}</td>
              <td>{account.status}</td>
              <td>{account.registrationDate}</td>
              <td>
                <button onClick={() => handleEdit(account.id)}>Editar</button>
                <button onClick={() => handleDelete(account.id)}>Excluir</button>
                <select 
                  value={account.status} 
                  onChange={(e) => handleStatusChange(account.id, e.target.value)}
                >
                  <option value="pendente">Pendente</option>
                  <option value="paga">Paga</option>
                </select>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default AccountManagementPage;
