[%bs.raw {|require('./app.css')|}];

[@bs.module] external logo : string = "./logo.svg";

let component = ReasonReact.statelessComponent("App");

/* 
  the '~' symbol indicating that it was passed into props and '_' symbol indicating that it
  was isn't used and ignored
*/
let make = (~message, _children) => {
  ...component,
  render: _self =>
    <div className="App">
      <div className="App-header">
        <img src=logo className="App-logo" alt="logo" />
        <h2> (ReasonReact.string(message)) </h2>
      </div>
      <p className="App-intro">
        <Todo />
      </p>
    </div>,
};
