// src/components/LoanForm.js
import { useState } from "react";

export default function LoanForm() {
  const [personalCode, setPersonalCode] = useState("");
  const [loanAmount, setLoanAmount] = useState(2000);
  const [period, setPeriod] = useState(12);
  const [result, setResult] = useState(null);

const handleSubmit = async (e) => {
  e.preventDefault();


  if (period < 12 || period > 60) {
    alert("Loan period must be between 12 and 60 months");
    return;
  }

  if (loanAmount < 2000 || loanAmount > 10000) {
    alert("Loan amount must be betwen 2000€ and 10000€")
    return;
  }

  try {
    const response = await fetch("http://localhost:8080/decision", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        personalCode: personalCode,
        loanAmount: loanAmount,
        period: period
      })
    });

    if (!response.ok) {
      throw new Error("Request failed");
    }

    const data = await response.json();
    setResult(data);

  } catch (error) {
    console.error("Error:", error);
  }
};

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Personal Code:</label>
          <input value={personalCode} onChange={e => setPersonalCode(e.target.value)} />
        </div>
        <div>
          <label>Loan Amount (€):</label>
          <input type="number" value={loanAmount} onChange={e => setLoanAmount(parseInt(e.target.value))} />
        </div>
        <div>
          <label>Loan Period (months):</label>
          <input type="number" value={period} onChange={e => setPeriod(parseInt(e.target.value))} />
        </div>
        <button type="submit">Check Loan</button>
      </form>

      {result && (
        <div style={{ marginTop: "20px" }}>
          <p>Approved: {result.approved ? "Yes" : "No"}</p>
          <p>Approved Amount: €{result.approvedAmount}</p>
          <p>Period: {result.period} months</p>
        </div>
      )}
    </div>
  );
}