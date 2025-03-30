import { NavLink } from 'react-router-dom';

function Header() {
  const navItems = [
    { label: 'Games', route: '/games' },
    { label: 'Upcoming', route: '/upcoming' },
    { label: 'News', route: '/news' },
    { label: 'Store', route: '/store' },
    { label: 'About', route: '/about' },
    { label: 'Feedback', route: '/feedback' },
  ];

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
      <div className="container-fluid">
        <NavLink className="navbar-brand" to="/">
          FragPunk
        </NavLink>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">
            {navItems.map((item) => (
              <li className="nav-item" key={item.route}>
                <NavLink
                  className={({ isActive }) =>
                    isActive ? 'nav-link active' : 'nav-link'
                  }
                  to={item.route}
                >
                  {item.label}
                </NavLink>
              </li>
            ))}
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Header;