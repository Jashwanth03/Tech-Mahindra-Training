function About() {
  return (
    <section className="about-section py-4 min-vh-100">
      <div className="container">
        <h2 className="text-center mb-4 text-warning">About FragPunk</h2>
        <div className="row g-4">
          <div className="col-12">
            <p className="text-center lead">
              Welcome to FragPunk, your ultimate gaming platform!
            </p>
            <p>
              FragPunk is a dedicated space for gamers to explore, discover, and stay updated on the latest and greatest in the gaming world. Launched in 2025, we aim to bring you comprehensive coverage of released and upcoming titles, exclusive news, and a store to grab your favorite games—all in one place.
            </p>
          </div>
          <div className="col-12">
            <h3 className="text-warning">Our Mission</h3>
            <p>
              Our mission is to connect gamers with the titles they love and provide a seamless experience for tracking upcoming releases, reading the latest news, and purchasing games. Whether you’re a fan of open-world adventures, fast-paced racing, or mythological RPGs, FragPunk has something for you.
            </p>
          </div>
          <div className="col-12">
            <h3 className="text-warning">Why Choose FragPunk?</h3>
            <ul className="list-unstyled">
              <li className="mb-2">
                <span className="text-success fw-bold">✓</span> Curated game library with detailed info.
              </li>
              <li className="mb-2">
                <span className="text-success fw-bold">✓</span> Up-to-date news from the gaming industry.
              </li>
              <li className="mb-2">
                <span className="text-success fw-bold">✓</span> Easy-to-use store for instant purchases.
              </li>
              <li className="mb-2">
                <span className="text-success fw-bold">✓</span> Community feedback to shape our platform.
              </li>
            </ul>
          </div>
          <div className="col-12 text-center">
            <p>
              Join us on this journey and experience gaming like never before! Have questions or suggestions? Visit our <a href="/feedback" className="text-warning">Feedback</a> page to let us know.
            </p>
          </div>
        </div>
      </div>
    </section>
  );
}

export default About;