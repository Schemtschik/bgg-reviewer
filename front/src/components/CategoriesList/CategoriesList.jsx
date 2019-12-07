import React, { Component } from "react";
import {Button} from "react-bootstrap";

export class CategoriesList extends Component {
    state = {
        list: []
    };

    componentDidMount() {
        fetch('/api/get-' + this.props.type)
            .then(res => res.json())
            .then((data) => {
                this.setState({ list: data.result })
            })
            .catch(console.log)
    }

    render() {
        return (
            this.state.list.map(item => {
                return (
                    <a href={"/admin/cat?type=" + this.props.type + "&id=" + item.id}>
                        <Button bsStyle="primary sm">
                            {item.name}
                        </Button>
                    </a>
                )
            })
        );
    }
}

export default CategoriesList;
