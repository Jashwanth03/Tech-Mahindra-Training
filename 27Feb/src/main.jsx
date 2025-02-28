import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import ABComponentForError from '../../28Feb/components/ABComponentForError.jsx'
import ErrorBoundary from '../../28Feb/components/ErrorBoundary.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App /> 
    <ErrorBoundary>
        <ABComponentForError/>
    </ErrorBoundary>

  </StrictMode>,
)
