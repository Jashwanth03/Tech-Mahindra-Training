import React, { Component } from "react";

export default class ErrorBoundary extends Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false };
  }
componentDidCatch(err, errInfo) {
    console.error("Error :" + err);
    console.error("Error info:" + errInfo);
    this.state({ hasError: true });
  }
render() {
    if (this.state.hasError) {
      return (
        <div>
          ErrorBoundary
          <h2>Something went wrong!!!!</h2>
        </div>
      );
    }
    return this.props.children;
  }
}