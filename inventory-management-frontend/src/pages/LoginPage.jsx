import React from 'react';
import { useDispatch } from 'react-redux';
import styled from 'styled-components';
import { AccountCircle, Lock } from '@mui/icons-material';

// import { login } from '../actions';

const LoginPage = () => {
  const dispatch = useDispatch();

  const handleSubmit = (event) => {
    event.preventDefault();
    const { username, password } = event.target.elements;
    dispatch(login(username.value, password.value));
  };

  return (
    <Container>
      <LoginForm onSubmit={handleSubmit}>
        <InputContainer>
          <StyledAccountCircle />
          <Input type="text" name="username" placeholder="Username" />
        </InputContainer>
        <InputContainer>
          <StyledLock />
          <Input type="password" name="password" placeholder="Password" />
        </InputContainer>
        <ButtonContainer>
          <Button type="submit">Login</Button>
        </ButtonContainer>
      </LoginForm>
    </Container>
  );
};

const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
`;

const LoginForm = styled.form`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
`;

const InputContainer = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 10px;
`;

const StyledAccountCircle = styled(AccountCircle)`
  margin-right: 10px;
`;

const StyledLock = styled(Lock)`
  margin-right: 10px;
`;

const Input = styled.input`
  border: none;
  border-bottom: 1px solid #ccc;
  margin-left: 10px;
  padding: 5px;
  font-size: 16px;
  width: 100%;
`;

const ButtonContainer = styled.div`
  margin-top: 20px;
`;

const Button = styled.button`
  background-color: #2196f3;
  color: white;
  border: none;
  border-radius: 5px;
  padding: 10px;
  font-size: 16px;
  cursor: pointer;

  &:hover {
    background-color: #0d8bf2;
  }
`;

export default LoginPage;
