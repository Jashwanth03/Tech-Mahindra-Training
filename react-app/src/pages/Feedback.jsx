import { useState } from 'react';

function Feedback() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    subject: '',
    message: '',
  });

  const [errors, setErrors] = useState({});

  const validateForm = () => {
    const newErrors = {};
    if (!formData.name || formData.name.length < 2) {
      newErrors.name = 'Name is required and must be at least 2 characters.';
    }
    if (!formData.email || !/\S+@\S+\.\S+/.test(formData.email)) {
      newErrors.email = 'A valid email is required.';
    }
    if (!formData.subject) {
      newErrors.subject = 'Subject is required.';
    }
    if (!formData.message || formData.message.length > 500) {
      newErrors.message = 'Message is required and must be under 500 characters.';
    }
    return newErrors;
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const validationErrors = validateForm();
    if (Object.keys(validationErrors).length === 0) {
      console.log('Feedback Submitted:', formData);
      alert('Thank you for your feedback! We will review it soon.');
      setFormData({ name: '', email: '', subject: '', message: '' });
      setErrors({});
    } else {
      setErrors(validationErrors);
    }
  };

  return (
    <section className="feedback-section py-4">
      <h2 className="text-center mb-4 text-warning">Send Us Your Feedback</h2>
      <form onSubmit={handleSubmit} className="mx-auto" style={{ maxWidth: '600px' }}>
        <div className="mb-3">
          <label htmlFor="name" className="form-label">Name</label>
          <input
            type="text"
            className="form-control bg-dark text-white border-secondary"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            placeholder="Enter your name"
          />
          {errors.name && <div className="text-danger mt-1">{errors.name}</div>}
        </div>

        <div className="mb-3">
          <label htmlFor="email" className="form-label">Email</label>
          <input
            type="email"
            className="form-control bg-dark text-white border-secondary"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Enter your email"
          />
          {errors.email && <div className="text-danger mt-1">{errors.email}</div>}
        </div>

        <div className="mb-3">
          <label htmlFor="subject" className="form-label">Subject</label>
          <input
            type="text"
            className="form-control bg-dark text-white border-secondary"
            id="subject"
            name="subject"
            value={formData.subject}
            onChange={handleChange}
            placeholder="Enter subject"
          />
          {errors.subject && <div className="text-danger mt-1">{errors.subject}</div>}
        </div>

        <div className="mb-3">
          <label htmlFor="message" className="form-label">Message</label>
          <textarea
            className="form-control bg-dark text-white border-secondary"
            id="message"
            name="message"
            value={formData.message}
            onChange={handleChange}
            placeholder="Enter your feedback"
            rows="5"
          />
          {errors.message && <div className="text-danger mt-1">{errors.message}</div>}
        </div>

        <button type="submit" className="btn btn-warning w-100">Submit Feedback</button>
      </form>
    </section>
  );
}

export default Feedback;